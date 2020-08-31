package com.ls.pojo;

/**
 * 封装分页相关信息
 */
public class Page {

    //当前页码
    private int currentPage = 1;

    //每页显示记录数
    private int pageSize = 10;

    //总记录数
    private int totalCount;

    //路径，便于复用
    private String path;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage >= 1) {
            this.currentPage = currentPage;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     * @return
     */
    public int getStartIndex(){
        //currentPage * pageSize - pageSize
        return (currentPage - 1) * pageSize;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotalPage(){
        if (totalCount % pageSize == 0) {
            return totalCount / pageSize;
        } else {
            return totalCount / pageSize + 1;
        }
    }

    /**
     * 获取起始页码
     * @return
     */
    public int getFrom(){
        int from;
        if (currentPage == getTotalPage()) {
            from = currentPage - 4;
        } else if (currentPage == (getCurrentPage() - 1)) {
            from = currentPage - 3;
        } else {
            from = currentPage - 2;
        }
        return from < 1 ? 1 : from;
    }

    /**
     * 获取结束页码
     * @return
     */
    public int getTo(){
        int to;
        if (currentPage == 1){
            to = currentPage + 4;
        } else if (currentPage == 2){
            to = currentPage + 3;
        } else {
            to = currentPage + 2;
        }
        int total = getTotalPage();
        return to > total ? total : to;
    }

}
