package testData;

public enum Cities {
    MOSCOW("Москва"), ST_PETERSBURG("Санкт-Петербург");
    private String city;

    Cities(String city) {
        this.city = city;
    }
    public String getCity(){
        return city;
    }
}
