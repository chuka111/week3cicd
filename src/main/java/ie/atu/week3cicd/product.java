package ie.atu.week3cicd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class product {
    private String id;
    private String name;
    private String category;
    private double price;

}
