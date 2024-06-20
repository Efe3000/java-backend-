package be.ucll.model;

import jakarta.validation.constraints.NotBlank;

public class Magazine extends Publication {

@NotBlank(message = "Editor is required")
private String editor;

@NotBlank(message = "ISSN is required")
private String issn;

public Magazine(int availableCopies, String title, String editor, String issn, int publicationYear){
    super(availableCopies, title, publicationYear); 

    setIssn(issn);
    setEditor(editor);

}


public void setEditor(String editor) {
    this.editor = editor;
}

public void setIssn(String issn) {
    if(issn.isEmpty() ||issn.trim().isEmpty()) {
        throw new DomainException("issn cannot be empty");
    }
    this.issn = issn;
}

public String getEditor() {
    return editor;
}

public String getIssn() {
    return issn;
}










}
