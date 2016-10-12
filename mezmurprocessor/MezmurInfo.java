/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mezmurprocessor;

/**
 *
 * @author Filippo
 */
public class MezmurInfo implements Comparable<MezmurInfo> {
    
    private String mezmurId;
    private String mezmurTitle;
    private String mezmurBody;
    private String mezmurCreatedDate;
    private String mezmurModifiedDate;
    private boolean mezmurStatus;
    private String mezmurOwner;
    private String mezmurAudioURL;
    private String mezmurVideoURL;
    private String mezmurExtraInfo;
    private String mezmurCategoryId;
    private int mezmurOrderInCategory;

    public void setMezmurId(String mezmurId) {
        this.mezmurId = mezmurId;
    }

    public void setMezmurTitle(String mezmurTitle) {
        this.mezmurTitle = mezmurTitle;
    }

    public void setMezmurBody(String mezmurBody) {
        this.mezmurBody = mezmurBody;
    }

    public void setMezmurCreatedDate(String mezmurCreatedDate) {
        this.mezmurCreatedDate = mezmurCreatedDate;
    }

    public void setMezmurModifiedDate(String mezmurModifiedDate) {
        this.mezmurModifiedDate = mezmurModifiedDate;
    }

    public void setMezmurStatus(boolean mezmurStatus) {
        this.mezmurStatus = mezmurStatus;
    }

    public void setMezmurOwner(String mezmurOwner) {
        this.mezmurOwner = mezmurOwner;
    }

    public void setMezmurAudioURL(String mezmurAudioURL) {
        this.mezmurAudioURL = mezmurAudioURL;
    }

    public void setMezmurVideoURL(String mezmurVideoURL) {
        this.mezmurVideoURL = mezmurVideoURL;
    }

    public void setMezmurExtraInfo(String mezmurExtraInfo) {
        this.mezmurExtraInfo = mezmurExtraInfo;
    }

    public void setMezmurCategoryId(String mezmurCategoryId) {
        this.mezmurCategoryId = mezmurCategoryId;
    }

    public void setMezmurOrderInCategory(int mezmurOrderInCategory) {
        this.mezmurOrderInCategory = mezmurOrderInCategory;
    }

    @Override
    public int compareTo(MezmurInfo o) {
        if (this != null && o != null) {
            
            String mTO1 = mezmurTitle.trim();
            String mBO1 = mezmurBody.trim();
            
            String mTO2 = o.mezmurTitle.trim();
            String mBO2 = mezmurBody.trim();
            if (mTO1 == null && mTO2 == null && mBO1 == null && mBO2 == null) {
                return 0;
            } else if (mTO1 == null && mBO1 == null) {
                return -1;
            } else if (mTO2 == null && mBO2 == null) {
                return 1;
            } else {
                return mTO1.compareTo(mTO2);
            }
        } else if (this == null && o == null) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return String.format("Mezmur Info >> mezmurId - %s, mezmurTitle - %s, mezmurBody - %s", mezmurId,
                mezmurTitle, mezmurBody); //To change body of generated methods, choose Tools | Templates.
    }
}
