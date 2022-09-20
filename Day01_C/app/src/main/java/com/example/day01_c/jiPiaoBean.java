package com.example.day01_c;

import java.util.List;


public class jiPiaoBean {

    private String code;
    private datas datas;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public jiPiaoBean.datas getDatas() {
        return datas;
    }

    public void setDatas(jiPiaoBean.datas datas) {
        this.datas = datas;
    }

    public class datas{

        private Boolean verifySuccess;
        private userinfo userinfo;

        public Boolean getVerifySuccess() {
            return verifySuccess;
        }

        public void setVerifySuccess(Boolean verifySuccess) {
            this.verifySuccess = verifySuccess;
        }

        public jiPiaoBean.datas.userinfo getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(jiPiaoBean.datas.userinfo userinfo) {
            this.userinfo = userinfo;
        }

        public class userinfo{

            private List<data> data;

            public List<jiPiaoBean.datas.userinfo.data> getData() {
                return data;
            }

            public void setData(List<jiPiaoBean.datas.userinfo.data> data) {
                this.data = data;
            }

            public class data{

                private String time;
                private String name;
                private String starttime;
                private String endtime;
                private String number;
                private String lowestprice;

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getStarttime() {
                    return starttime;
                }

                public void setStarttime(String starttime) {
                    this.starttime = starttime;
                }

                public String getEndtime() {
                    return endtime;
                }

                public void setEndtime(String endtime) {
                    this.endtime = endtime;
                }

                public String getNumber() {
                    return number;
                }

                public void setNumber(String number) {
                    this.number = number;
                }

                public String getLowestprice() {
                    return lowestprice;
                }

                public void setLowestprice(String lowestprice) {
                    this.lowestprice = lowestprice;
                }
            }
        }
    }


}
