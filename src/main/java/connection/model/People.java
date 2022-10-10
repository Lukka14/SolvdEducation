package connection.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {
    private Long id;
    private String firstName;
    private String lastName;
    private Long professionId;
    private Long carId;
    private Long petId;
}
