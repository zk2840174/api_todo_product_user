package org.zerock.mallapi.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tbl_sample_user")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleUser {

    @Id
    private String uid;

    private String upw;

    private String uname;

    private String email;

    public void changePassword(String upw) {
        this.upw = upw;
    }

    public void changeUsername(String uname) {
        this.uname = uname;
    }

}
