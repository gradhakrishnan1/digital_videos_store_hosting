package com.seneca.digitalvideostore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@Document("movieAndTvShowData")
public class MovieAndTvShowData {
    @Id
    private String _id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price should be greater than 0.0")
    private BigDecimal price;

    @NotBlank(message = "Synopsis is mandatory")
    private String synopsis;

    private ShowType showType;

    @NotBlank(message = "Small poster path not provided")
    private String smallPoster;

    @NotBlank(message = "Large poster path not provided")
    private String largePoster;

    @DecimalMin(value = "0.0", inclusive = false, message = "Rent Price should be greater than 0.0")
    private BigDecimal rentPrice;

    @DecimalMin(value = "0.0", inclusive = false, message = "Purchase Price should be greater than 0.0")
    private BigDecimal purchasePrice;

    private boolean featured;
}
