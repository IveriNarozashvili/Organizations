import java.util.Objects;

public class CennieBumagi {

    private String code;
    private String dateOfEnd;
    private String nameOfOwner;
    private String money;
    private String id;

    @Override
    public String toString() {
        return "CennieBumagi{" +
                "code='" + code + '\'' +
                ", dateOfEnd='" + dateOfEnd + '\'' +
                ", nameOfOwner='" + nameOfOwner + '\'' +
                ", money='" + money + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CennieBumagi that = (CennieBumagi) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(dateOfEnd, that.dateOfEnd) &&
                Objects.equals(nameOfOwner, that.nameOfOwner) &&
                Objects.equals(money, that.money) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, dateOfEnd, nameOfOwner, money, id);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(String dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
