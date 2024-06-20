package be.ucll.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class MagazineTest {
private static ValidatorFactory validatorFactory;
    private static Validator validator;
    @BeforeAll
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }
@Test
void givenAllInputsAreValid_whenCalled_ThenMagazineIsCreated() {
    Magazine magazine = new Magazine(0, "title", "editor", "1234567890000", 2022);
    assertEquals("title", magazine.getTitle());
    assertEquals("editor", magazine.getEditor());
    assertEquals("1234567890000", magazine.getIssn());
    assertEquals(2022, magazine.getPublicationYear());


}

@Test
void givenTitleIsEmpty_whenCalled_ThenAnErrorIsCalled() {
    // Test when title is empty
    assertThrows(DomainException.class, () -> {new Magazine(0, "","editor","123456789000",2022); });

}


@Test
void givenInValidIssn_whenCalled_ThenAnErrorIsCalled() {
    // Test when title is empty
    assertThrows(DomainException.class, () -> {new Magazine(0, "title","editor","",2022); });

}

 @Test
    public void givenEmptyEditor_whenCreatingMagazine_thenThrowsException() {
        Magazine testMagazine = new Magazine(2022, "Sample Title", "", "1234-5678", 10);
        Set<ConstraintViolation<Magazine>> violations = validator.validate(testMagazine);
        assertEquals(1, violations.size());
        ConstraintViolation<Magazine> violation = violations.iterator().next();
        assertEquals("Editor is required", violation.getMessage());
    }
// @Test
// void givenEmptyEditor_whenCalled_ThenAnErrorIsCalled() {
//     // Test when title is empty
//     assertThrows(DomainException.class, () -> {new Magazine(0, "title","","123456789000",2022); });

// }

@Test
void givenInvalidPublicationYear_whenCalled_ThenAnErrorIsCalled() {
    // Test when title is empty
    assertThrows(DomainException.class, () -> {new Magazine(0, "title","editor","123456789000",-1); });
}




}