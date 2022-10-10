package connection.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Long id;
    private String Brand;
    private String Model;
    private Long price;
    private Long peopleId;
    private Long countryId;
}
