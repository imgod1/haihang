package com.imgod1.haihang.haihang;

import java.util.List;

/**
 * ListResponse.java是液总汇的类。
 *
 * @author imgod1
 * @version 2.0.0 2018/5/12 18:11
 * @update imgod1 2018/5/12 18:11
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class ListResponse {

    /**
     * msg : success
     * resultCode : 50
     * obj : {"footer":{"sumOrd":217,"sysDate":1526117959000},"currentPage":1,"pageCount":1,"recordCount":5,"startPage":1,"endPage":1,"pages":[1],"maxShowPageNum":6,"sqlWhere":null,"dataList":[{"totalQuantity":150,"addBill":0.005,"proIdent":"V_1_5000_450","reSoldoutTime":1647310195000,"showPrice":5000,"code":"36970291201803151011124621443","endTime":1647310195000,"packageStatus":50,"availableQuantity":0,"startTime":1521084180000,"giveBill":0.045,"price":4976.34,"name":"5000元1月话费包","totalCycle":1,"isStaff":"0","generalizeType":"addbill","reProductTime":1521079792000},{"totalQuantity":500,"addBill":0.005,"proIdent":"V_7_2_819.9999999999999","reSoldoutTime":1608047750000,"showPrice":20000,"code":"72406116201712151536107472037","endTime":1608047750000,"packageStatus":50,"availableQuantity":415,"startTime":1513323660000,"giveBill":0.082,"price":19067.92,"name":"2万元7月话费包","totalCycle":7,"isStaff":"0","generalizeType":"addbill","reProductTime":1513323288000},{"totalQuantity":20,"addBill":0.002,"proIdent":"V_9_50_820","reSoldoutTime":1609404801000,"showPrice":500000,"code":"13124117201709151655175391889","endTime":1609404801000,"packageStatus":50,"availableQuantity":10,"startTime":1505467920000,"giveBill":0.082,"price":470560.53,"name":"50万元9月话费包","totalCycle":9,"isStaff":"0","generalizeType":"addbill","reProductTime":1505465600000},{"totalQuantity":30,"addBill":0.01,"proIdent":"V_12_20_950","reSoldoutTime":1667114175000,"showPrice":200000,"code":"3410708820180417104135570356","endTime":1667114175000,"packageStatus":50,"availableQuantity":22,"startTime":1509347770000,"giveBill":0.105,"price":180814.48,"name":"20万元12月话费包","totalCycle":12,"isStaff":"0","generalizeType":"addbill","reProductTime":1509347770000},{"totalQuantity":20,"addBill":0.015,"proIdent":"V_12_50_1000","reSoldoutTime":1672385066000,"showPrice":500000,"code":"7907065520180423141045948820","endTime":1672385066000,"packageStatus":50,"availableQuantity":5,"startTime":1509348262000,"giveBill":0.115,"price":447982.06,"name":"50万元12月话费包","totalCycle":12,"isStaff":"0","generalizeType":"addbill","reProductTime":1509348262000}],"beginRow":0,"pageSize":10,"queryMap":{"time":"1525772342237","sort":"8","pageSize":"10","pageNumber":"1","generalizeType":"addbill","packageStatus":"50"}}
     */

    private String msg;
    private int resultCode;
    private ObjBean obj;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * footer : {"sumOrd":217,"sysDate":1526117959000}
         * currentPage : 1
         * pageCount : 1
         * recordCount : 5
         * startPage : 1
         * endPage : 1
         * pages : [1]
         * maxShowPageNum : 6
         * sqlWhere : null
         * dataList : [{"totalQuantity":150,"addBill":0.005,"proIdent":"V_1_5000_450","reSoldoutTime":1647310195000,"showPrice":5000,"code":"36970291201803151011124621443","endTime":1647310195000,"packageStatus":50,"availableQuantity":0,"startTime":1521084180000,"giveBill":0.045,"price":4976.34,"name":"5000元1月话费包","totalCycle":1,"isStaff":"0","generalizeType":"addbill","reProductTime":1521079792000},{"totalQuantity":500,"addBill":0.005,"proIdent":"V_7_2_819.9999999999999","reSoldoutTime":1608047750000,"showPrice":20000,"code":"72406116201712151536107472037","endTime":1608047750000,"packageStatus":50,"availableQuantity":415,"startTime":1513323660000,"giveBill":0.082,"price":19067.92,"name":"2万元7月话费包","totalCycle":7,"isStaff":"0","generalizeType":"addbill","reProductTime":1513323288000},{"totalQuantity":20,"addBill":0.002,"proIdent":"V_9_50_820","reSoldoutTime":1609404801000,"showPrice":500000,"code":"13124117201709151655175391889","endTime":1609404801000,"packageStatus":50,"availableQuantity":10,"startTime":1505467920000,"giveBill":0.082,"price":470560.53,"name":"50万元9月话费包","totalCycle":9,"isStaff":"0","generalizeType":"addbill","reProductTime":1505465600000},{"totalQuantity":30,"addBill":0.01,"proIdent":"V_12_20_950","reSoldoutTime":1667114175000,"showPrice":200000,"code":"3410708820180417104135570356","endTime":1667114175000,"packageStatus":50,"availableQuantity":22,"startTime":1509347770000,"giveBill":0.105,"price":180814.48,"name":"20万元12月话费包","totalCycle":12,"isStaff":"0","generalizeType":"addbill","reProductTime":1509347770000},{"totalQuantity":20,"addBill":0.015,"proIdent":"V_12_50_1000","reSoldoutTime":1672385066000,"showPrice":500000,"code":"7907065520180423141045948820","endTime":1672385066000,"packageStatus":50,"availableQuantity":5,"startTime":1509348262000,"giveBill":0.115,"price":447982.06,"name":"50万元12月话费包","totalCycle":12,"isStaff":"0","generalizeType":"addbill","reProductTime":1509348262000}]
         * beginRow : 0
         * pageSize : 10
         * queryMap : {"time":"1525772342237","sort":"8","pageSize":"10","pageNumber":"1","generalizeType":"addbill","packageStatus":"50"}
         */

        private FooterBean footer;
        private int currentPage;
        private int pageCount;
        private int recordCount;
        private int startPage;
        private int endPage;
        private int maxShowPageNum;
        private Object sqlWhere;
        private int beginRow;
        private int pageSize;
        private QueryMapBean queryMap;
        private List<Integer> pages;
        private List<DataListBean> dataList;

        public FooterBean getFooter() {
            return footer;
        }

        public void setFooter(FooterBean footer) {
            this.footer = footer;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getRecordCount() {
            return recordCount;
        }

        public void setRecordCount(int recordCount) {
            this.recordCount = recordCount;
        }

        public int getStartPage() {
            return startPage;
        }

        public void setStartPage(int startPage) {
            this.startPage = startPage;
        }

        public int getEndPage() {
            return endPage;
        }

        public void setEndPage(int endPage) {
            this.endPage = endPage;
        }

        public int getMaxShowPageNum() {
            return maxShowPageNum;
        }

        public void setMaxShowPageNum(int maxShowPageNum) {
            this.maxShowPageNum = maxShowPageNum;
        }

        public Object getSqlWhere() {
            return sqlWhere;
        }

        public void setSqlWhere(Object sqlWhere) {
            this.sqlWhere = sqlWhere;
        }

        public int getBeginRow() {
            return beginRow;
        }

        public void setBeginRow(int beginRow) {
            this.beginRow = beginRow;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public QueryMapBean getQueryMap() {
            return queryMap;
        }

        public void setQueryMap(QueryMapBean queryMap) {
            this.queryMap = queryMap;
        }

        public List<Integer> getPages() {
            return pages;
        }

        public void setPages(List<Integer> pages) {
            this.pages = pages;
        }

        public List<DataListBean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListBean> dataList) {
            this.dataList = dataList;
        }

        public static class FooterBean {
            /**
             * sumOrd : 217
             * sysDate : 1526117959000
             */

            private int sumOrd;
            private long sysDate;

            public int getSumOrd() {
                return sumOrd;
            }

            public void setSumOrd(int sumOrd) {
                this.sumOrd = sumOrd;
            }

            public long getSysDate() {
                return sysDate;
            }

            public void setSysDate(long sysDate) {
                this.sysDate = sysDate;
            }
        }

        public static class QueryMapBean {
            /**
             * time : 1525772342237
             * sort : 8
             * pageSize : 10
             * pageNumber : 1
             * generalizeType : addbill
             * packageStatus : 50
             */

            private String time;
            private String sort;
            private String pageSize;
            private String pageNumber;
            private String generalizeType;
            private String packageStatus;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getPageSize() {
                return pageSize;
            }

            public void setPageSize(String pageSize) {
                this.pageSize = pageSize;
            }

            public String getPageNumber() {
                return pageNumber;
            }

            public void setPageNumber(String pageNumber) {
                this.pageNumber = pageNumber;
            }

            public String getGeneralizeType() {
                return generalizeType;
            }

            public void setGeneralizeType(String generalizeType) {
                this.generalizeType = generalizeType;
            }

            public String getPackageStatus() {
                return packageStatus;
            }

            public void setPackageStatus(String packageStatus) {
                this.packageStatus = packageStatus;
            }
        }

        public static class DataListBean {
            /**
             * totalQuantity : 150
             * addBill : 0.005
             * proIdent : V_1_5000_450
             * reSoldoutTime : 1647310195000
             * showPrice : 5000
             * code : 36970291201803151011124621443
             * endTime : 1647310195000
             * packageStatus : 50
             * availableQuantity : 0
             * startTime : 1521084180000
             * giveBill : 0.045
             * price : 4976.34
             * name : 5000元1月话费包
             * totalCycle : 1
             * isStaff : 0
             * generalizeType : addbill
             * reProductTime : 1521079792000
             */

            private int totalQuantity;
            private double addBill;
            private String proIdent;
            private long reSoldoutTime;
            private int showPrice;
            private String code;
            private long endTime;
            private int packageStatus;
            private int availableQuantity;
            private long startTime;
            private double giveBill;
            private double price;
            private String name;
            private int totalCycle;
            private String isStaff;
            private String generalizeType;
            private long reProductTime;

            public int getTotalQuantity() {
                return totalQuantity;
            }

            public void setTotalQuantity(int totalQuantity) {
                this.totalQuantity = totalQuantity;
            }

            public double getAddBill() {
                return addBill;
            }

            public void setAddBill(double addBill) {
                this.addBill = addBill;
            }

            public String getProIdent() {
                return proIdent;
            }

            public void setProIdent(String proIdent) {
                this.proIdent = proIdent;
            }

            public long getReSoldoutTime() {
                return reSoldoutTime;
            }

            public void setReSoldoutTime(long reSoldoutTime) {
                this.reSoldoutTime = reSoldoutTime;
            }

            public int getShowPrice() {
                return showPrice;
            }

            public void setShowPrice(int showPrice) {
                this.showPrice = showPrice;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public long getEndTime() {
                return endTime;
            }

            public void setEndTime(long endTime) {
                this.endTime = endTime;
            }

            public int getPackageStatus() {
                return packageStatus;
            }

            public void setPackageStatus(int packageStatus) {
                this.packageStatus = packageStatus;
            }

            public int getAvailableQuantity() {
                return availableQuantity;
            }

            public void setAvailableQuantity(int availableQuantity) {
                this.availableQuantity = availableQuantity;
            }

            public long getStartTime() {
                return startTime;
            }

            public void setStartTime(long startTime) {
                this.startTime = startTime;
            }

            public double getGiveBill() {
                return giveBill;
            }

            public void setGiveBill(double giveBill) {
                this.giveBill = giveBill;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getTotalCycle() {
                return totalCycle;
            }

            public void setTotalCycle(int totalCycle) {
                this.totalCycle = totalCycle;
            }

            public String getIsStaff() {
                return isStaff;
            }

            public void setIsStaff(String isStaff) {
                this.isStaff = isStaff;
            }

            public String getGeneralizeType() {
                return generalizeType;
            }

            public void setGeneralizeType(String generalizeType) {
                this.generalizeType = generalizeType;
            }

            public long getReProductTime() {
                return reProductTime;
            }

            public void setReProductTime(long reProductTime) {
                this.reProductTime = reProductTime;
            }
        }
    }
}
