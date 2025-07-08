package study.min.aroundhub.dto;

public class MemberDTO {
    private String name;
    private String email;

    //region Getter/Setter
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //endregion

    public String toString() {
        return "MemberDTO(name=" + this.getName() + ", email=" + this.getEmail() + ")";
    }
}
