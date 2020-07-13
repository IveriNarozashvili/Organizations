import java.util.Objects;

public class Organization {

    private String nameShort;
    private String nameFull;
    private String address;
    private String numberPhone;
    private String dateOfEstablishment;
    private String inn;
    private String number;
    private String ogrn;
    private CennieBumagi cennieBumagi;

    @Override
    public String toString() {
        return "Organization{" +
                "nameShort='" + nameShort + '\'' +
                ", nameFull='" + nameFull + '\'' +
                ", address='" + address + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", dateOfEstablishment='" + dateOfEstablishment + '\'' +
                ", inn='" + inn + '\'' +
                ", number='" + number + '\'' +
                ", ogrn='" + ogrn + '\'' +
                ", cennieBumagi=" + cennieBumagi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(nameShort, that.nameShort) &&
                Objects.equals(nameFull, that.nameFull) &&
                Objects.equals(address, that.address) &&
                Objects.equals(numberPhone, that.numberPhone) &&
                Objects.equals(dateOfEstablishment, that.dateOfEstablishment) &&
                Objects.equals(inn, that.inn) &&
                Objects.equals(number, that.number) &&
                Objects.equals(ogrn, that.ogrn) &&
                Objects.equals(cennieBumagi, that.cennieBumagi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameShort, nameFull, address, numberPhone, dateOfEstablishment, inn, number, ogrn, cennieBumagi);
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setDateOfEstablishment(String dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public CennieBumagi getCennieBumagi() {
        return cennieBumagi;
    }

    public void setCennieBumagi(CennieBumagi cennieBumagi) {
        this.cennieBumagi = cennieBumagi;
    }
}
