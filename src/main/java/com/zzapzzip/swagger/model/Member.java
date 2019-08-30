package com.zzapzzip.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@ApiModel("회원")
@NoArgsConstructor
@Getter
@Entity
@Table(name ="members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Member의 Id")
    private Long id;

    @Column
    @ApiModelProperty(value = "이름", required = true)
    private String firstName;

    @Column
    @ApiModelProperty(value = "성", required = true)
    private String lastName;

    @Builder
    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
