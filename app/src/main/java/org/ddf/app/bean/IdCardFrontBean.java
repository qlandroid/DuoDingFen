package org.ddf.app.bean;

/**
 * 描述：
 * 邮箱 email:strive_bug@yeah.net
 * 创建时间 2018/6/20
 *
 * @author ql
 */

public class IdCardFrontBean {

    /**
     * birthday : {"year":"1990","day":"15","month":"10"}
     * name : 邱亮
     * race : 汉
     * address : 黑龙江省尚志市尚志镇东风委充组39号
     * time_used : 1008
     * gender : 男
     * head_rect : {"rt":{"y":0.17232142,"x":0.7883065},"lt":{"y":0.20892857,"x":0.5405746},"lb":{"y":0.68794644,"x":0.5488911},"rb":{"y":0.66964287,"x":0.80040324}}
     * request_id : 1529487879,4924d70c-92c3-459e-9e58-b78a23ad9239
     * id_card_number : 230183199010150011
     * side : front
     * <p>
     * valid_date : 2015.02.25-2025.02.25
     * issued_by : 尚志市公安局
     */

    private BirthdayBean birthday;
    private String name;
    private String race;
    private String address;
    private int time_used;
    private String gender;
    private HeadRectBean head_rect;
    private String request_id;
    private String id_card_number;
    private String side;

    private String valid_date;
    private String issued_by;

    /**
     * 是否是身份证正面
     *
     * @return
     */
    public boolean isFront() {
        return "front".equals(side);
    }

    public String getValid_date() {
        return valid_date;
    }

    public void setValid_date(String valid_date) {
        this.valid_date = valid_date;
    }

    public String getIssued_by() {
        return issued_by;
    }

    public void setIssued_by(String issued_by) {
        this.issued_by = issued_by;
    }

    public BirthdayBean getBirthday() {
        return birthday;
    }

    public void setBirthday(BirthdayBean birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTime_used() {
        return time_used;
    }

    public void setTime_used(int time_used) {
        this.time_used = time_used;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public HeadRectBean getHead_rect() {
        return head_rect;
    }

    public void setHead_rect(HeadRectBean head_rect) {
        this.head_rect = head_rect;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getId_card_number() {
        return id_card_number;
    }

    public void setId_card_number(String id_card_number) {
        this.id_card_number = id_card_number;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public static class BirthdayBean {
        /**
         * year : 1990
         * day : 15
         * month : 10
         */

        private String year;
        private String day;
        private String month;

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }
    }

    public static class HeadRectBean {
        /**
         * rt : {"y":0.17232142,"x":0.7883065}
         * lt : {"y":0.20892857,"x":0.5405746}
         * lb : {"y":0.68794644,"x":0.5488911}
         * rb : {"y":0.66964287,"x":0.80040324}
         */

        private RtBean rt;
        private LtBean lt;
        private LbBean lb;
        private RbBean rb;

        public RtBean getRt() {
            return rt;
        }

        public void setRt(RtBean rt) {
            this.rt = rt;
        }

        public LtBean getLt() {
            return lt;
        }

        public void setLt(LtBean lt) {
            this.lt = lt;
        }

        public LbBean getLb() {
            return lb;
        }

        public void setLb(LbBean lb) {
            this.lb = lb;
        }

        public RbBean getRb() {
            return rb;
        }

        public void setRb(RbBean rb) {
            this.rb = rb;
        }

        public static class RtBean {
            /**
             * y : 0.17232142
             * x : 0.7883065
             */

            private double y;
            private double x;

            public double getY() {
                return y;
            }

            public void setY(double y) {
                this.y = y;
            }

            public double getX() {
                return x;
            }

            public void setX(double x) {
                this.x = x;
            }
        }

        public static class LtBean {
            /**
             * y : 0.20892857
             * x : 0.5405746
             */

            private double y;
            private double x;

            public double getY() {
                return y;
            }

            public void setY(double y) {
                this.y = y;
            }

            public double getX() {
                return x;
            }

            public void setX(double x) {
                this.x = x;
            }
        }

        public static class LbBean {
            /**
             * y : 0.68794644
             * x : 0.5488911
             */

            private double y;
            private double x;

            public double getY() {
                return y;
            }

            public void setY(double y) {
                this.y = y;
            }

            public double getX() {
                return x;
            }

            public void setX(double x) {
                this.x = x;
            }
        }

        public static class RbBean {
            /**
             * y : 0.66964287
             * x : 0.80040324
             */

            private double y;
            private double x;

            public double getY() {
                return y;
            }

            public void setY(double y) {
                this.y = y;
            }

            public double getX() {
                return x;
            }

            public void setX(double x) {
                this.x = x;
            }
        }
    }
}
