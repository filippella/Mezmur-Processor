/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mezmurprocessor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Filippo
 */
public class Main {

    public static void main(String[] args) {

        FileUtility utility = new FileUtility();
        String categoriesJson = utility.readFile("C:\\Users\\Filippo\\Desktop\\assets\\mezmur_categories.json");
        String binderJson = utility.readFile("C:\\Users\\Filippo\\Desktop\\assets\\mezmur_category_to_data_binder.json");
        String mezmurJson = utility.readFile("C:\\Users\\Filippo\\Desktop\\assets\\mezmur_data.json");

        Gson gson = new Gson();

        List<Category> categories = gson.fromJson(categoriesJson, new TypeToken<List<Category>>() {
        }.getType());
        List<Binder> binders = gson.fromJson(binderJson, new TypeToken<List<Binder>>() {
        }.getType());
        List<Mezmur> mezmurs = gson.fromJson(mezmurJson, new TypeToken<List<Mezmur>>() {
        }.getType());

        List<MezmurCategoryInfo> categoryInfos = new ArrayList<>();

        for (int i = 0; i < categories.size(); i++) {

            Category category = categories.get(i);

            String cid = category.getCid();
            String morder = category.getMorder();
            String name = category.getName();

            MezmurCategoryInfo info = new MezmurCategoryInfo(cid, name, morder);

            for (int j = 0; j < binders.size(); j++) {
                Binder mezmurDataBinder = binders.get(j);
                String dataBinderCid = mezmurDataBinder.getCid();

                if (dataBinderCid != null && dataBinderCid.equals(cid)) {
                    info.addMezmurId(mezmurDataBinder.getMid());
                }
            }
            categoryInfos.add(info);
        }

        List<MezmurInfo> mezmurInfos = new ArrayList<>();

        for (int i = 0; i < categoryInfos.size(); i++) {

            MezmurCategoryInfo categoryInfo = categoryInfos.get(i);
            List<String> mezmurIdList = categoryInfo.getMezmurIdList();

            for (int j = 0; j < mezmurIdList.size(); j++) {

                String mezmurId = mezmurIdList.get(j);

                for (int k = 0; k < mezmurs.size(); k++) {
                    Mezmur mezmur = mezmurs.get(k);
                    String mid = mezmur.getMid();
                    if (mezmur != null && mid != null && mid.equals(mezmurId)) {

                        MezmurInfo mezmurInfo = new MezmurInfo();

                        mezmurInfo.setMezmurId(mezmurId);
                        mezmurInfo.setMezmurTitle(mezmur.getTitle().trim().replace("test", ""));
                        mezmurInfo.setMezmurBody(mezmur.getText());
                        mezmurInfo.setMezmurAudioURL("");
                        mezmurInfo.setMezmurVideoURL("");
                        mezmurInfo.setMezmurCreatedDate(new Date().toString());
                        mezmurInfo.setMezmurModifiedDate(new Date().toString());
                        mezmurInfo.setMezmurStatus(true);
                        mezmurInfo.setMezmurOwner("Unknown");
                        mezmurInfo.setMezmurExtraInfo(mezmur.getNote());
                        mezmurInfo.setMezmurCategoryId(categoryInfo.getCid());
                        mezmurInfo.setMezmurOrderInCategory(-1);

                        if (mezmurInfos.size() > 0) {
                            for (int l = 0; l < mezmurInfos.size(); l++) {
                                MezmurInfo currentMezmurInfo = mezmurInfos.get(l);
                                int compareTo = currentMezmurInfo.compareTo(mezmurInfo);
                                if (compareTo != 0) {
                                    mezmurInfos.add(mezmurInfo);
                                    break;
                                } else {
                                    System.err.println("Duplicate Found!\n\n" + currentMezmurInfo);
                                }
                            }
                        } else {
                            mezmurInfos.add(mezmurInfo);
                            break;
                        }

                    }
                }
            }
        }

        String mezmurListJson = gson.toJson(mezmurInfos, new TypeToken<List<MezmurInfo>>() {
        }.getType());

        utility.writeFile(mezmurListJson);
        System.out.println("File Written successfully!");
    }
}
