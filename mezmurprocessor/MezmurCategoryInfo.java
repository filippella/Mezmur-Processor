/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mezmurprocessor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filippo
 */
public class MezmurCategoryInfo {
    
    private String cid;
    private String name;
    private String morder;
    private List<String> mezmurIdList = new ArrayList<>();

    public MezmurCategoryInfo(String cid, String name, String morder) {
        this.cid = cid;
        this.name = name;
        this.morder = morder;
    }
    
    public void addMezmurId(String mezmurId) {
        this.mezmurIdList.add(mezmurId);
    }

    public String getCid() {
        return cid;
    }

    public String getName() {
        return name;
    }

    public String getMorder() {
        return morder;
    }

    public List<String> getMezmurIdList() {
        return mezmurIdList;
    }
}
