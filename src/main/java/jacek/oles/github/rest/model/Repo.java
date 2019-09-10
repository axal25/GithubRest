package jacek.oles.github.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repo {
    String full_name, description, clone_url, created_at, stargazers_count;

    @Override
    public String toString() {
        return Json.toString( this );
    }
}
