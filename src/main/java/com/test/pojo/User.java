package com.test.pojo;

public class User {
    private String code;

    private String username;

    private String year;

    private String month;

    private String money;

    private String lifesub;

    private String retirementsub;

    private String housesub;

    private String laboursub;

    private String rescuesub;

    private String goversub;

    private String propertysub;

    private String nursemoney;

    private String worksub;

    private String reissue;

    private String relief;

    private String insurance16;

    private String insurance17;

    private String sum;

    private String watercost;

    private String electriccost;

    private String rent;

    private String otherrent;

    private String realsum;

    private String email;

    public User(String code, String username, String year, String month, String money, String lifesub, String retirementsub, String housesub, String laboursub, String rescuesub, String goversub, String propertysub, String nursemoney, String worksub, String reissue, String relief, String insurance16, String insurance17, String sum, String watercost, String electriccost, String rent, String otherrent, String realsum, String email) {
        this.code = code;
        this.username = username;
        this.year = year;
        this.month = month;
        this.money = money;
        this.lifesub = lifesub;
        this.retirementsub = retirementsub;
        this.housesub = housesub;
        this.laboursub = laboursub;
        this.rescuesub = rescuesub;
        this.goversub = goversub;
        this.propertysub = propertysub;
        this.nursemoney = nursemoney;
        this.worksub = worksub;
        this.reissue = reissue;
        this.relief = relief;
        this.insurance16 = insurance16;
        this.insurance17 = insurance17;
        this.sum = sum;
        this.watercost = watercost;
        this.electriccost = electriccost;
        this.rent = rent;
        this.otherrent = otherrent;
        this.realsum = realsum;
        this.email = email;
    }

    public User() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public String getLifesub() {
        return lifesub;
    }

    public void setLifesub(String lifesub) {
        this.lifesub = lifesub == null ? null : lifesub.trim();
    }

    public String getRetirementsub() {
        return retirementsub;
    }

    public void setRetirementsub(String retirementsub) {
        this.retirementsub = retirementsub == null ? null : retirementsub.trim();
    }

    public String getHousesub() {
        return housesub;
    }

    public void setHousesub(String housesub) {
        this.housesub = housesub == null ? null : housesub.trim();
    }

    public String getLaboursub() {
        return laboursub;
    }

    public void setLaboursub(String laboursub) {
        this.laboursub = laboursub == null ? null : laboursub.trim();
    }

    public String getRescuesub() {
        return rescuesub;
    }

    public void setRescuesub(String rescuesub) {
        this.rescuesub = rescuesub == null ? null : rescuesub.trim();
    }

    public String getGoversub() {
        return goversub;
    }

    public void setGoversub(String goversub) {
        this.goversub = goversub == null ? null : goversub.trim();
    }

    public String getPropertysub() {
        return propertysub;
    }

    public void setPropertysub(String propertysub) {
        this.propertysub = propertysub == null ? null : propertysub.trim();
    }

    public String getNursemoney() {
        return nursemoney;
    }

    public void setNursemoney(String nursemoney) {
        this.nursemoney = nursemoney == null ? null : nursemoney.trim();
    }

    public String getWorksub() {
        return worksub;
    }

    public void setWorksub(String worksub) {
        this.worksub = worksub == null ? null : worksub.trim();
    }

    public String getReissue() {
        return reissue;
    }

    public void setReissue(String reissue) {
        this.reissue = reissue == null ? null : reissue.trim();
    }

    public String getRelief() {
        return relief;
    }

    public void setRelief(String relief) {
        this.relief = relief == null ? null : relief.trim();
    }

    public String getInsurance16() {
        return insurance16;
    }

    public void setInsurance16(String insurance16) {
        this.insurance16 = insurance16 == null ? null : insurance16.trim();
    }

    public String getInsurance17() {
        return insurance17;
    }

    public void setInsurance17(String insurance17) {
        this.insurance17 = insurance17 == null ? null : insurance17.trim();
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum == null ? null : sum.trim();
    }

    public String getWatercost() {
        return watercost;
    }

    public void setWatercost(String watercost) {
        this.watercost = watercost == null ? null : watercost.trim();
    }

    public String getElectriccost() {
        return electriccost;
    }

    public void setElectriccost(String electriccost) {
        this.electriccost = electriccost == null ? null : electriccost.trim();
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent == null ? null : rent.trim();
    }

    public String getOtherrent() {
        return otherrent;
    }

    public void setOtherrent(String otherrent) {
        this.otherrent = otherrent == null ? null : otherrent.trim();
    }

    public String getRealsum() {
        return realsum;
    }

    public void setRealsum(String realsum) {
        this.realsum = realsum == null ? null : realsum.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}