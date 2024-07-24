package org.lehoangkhang.doublekperfume.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // Tên người dùng
    @Id
    @Column(name = "username")
    private String username;
    // Họ
    @Column(name = "first_name")
    private String firstName;
    // Tên
    @Column(name = "last_name")
    private String lastName;
    // Email
    @Column(name = "email")
    private String email;
    // Mật khẩu
    @Column(name = "password")
    private String password;

    // Trạng thái
    @Column(name = "enabled")
    private Boolean enabled;

    // Quyền
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
