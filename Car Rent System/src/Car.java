 class Car {
    private String carId;
    private String cmodel;
    private String cbrand;
    private double cbasepricepday;
    private boolean isavailable;
 // parameterize const
    public Car(String carId, String cmodel, String cbrand, double cbasepricepday) {
        this.carId = carId;
        this.cmodel = cmodel;
        this.cbrand = cbrand;
        this.cbasepricepday = cbasepricepday;
        this.isavailable = true;
    }
// getter
    public String getCarId() {
        return carId;
    }
    public String getCmodel() {
        return cmodel;
    }
    public String getCbrand() {
        return cbrand;
    }
    public double getCbaseprice() {
        return cbasepricepday;
    }

    public boolean isIsavailable() {
        return isavailable;
    }

    public double calculateprice(int rentDays){
        return cbasepricepday *rentDays;
    }
    public void rent(){
        isavailable=false;
    }
    public void returncar(){
        isavailable=true;
    }
}
