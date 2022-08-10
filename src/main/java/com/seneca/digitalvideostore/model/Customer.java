package com.seneca.digitalvideostore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Document("customer")
public class Customer {
    @Id
    @JsonIgnore
    private String _id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @Email
    @NotBlank(message = "Email Id is mandatory")
    private String email;

    @NotBlank
    @Pattern(regexp = "(?=\\S+$).+", message = "must contain no whitespace.")
    private String password;
}
