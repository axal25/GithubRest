package jacek.oles.github.rest.model.com.github.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jacek.oles.github.rest.model.Json;
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
    private String full_name, description, clone_url, created_at, stargazers_count;

    @Override
    public String toString() {
        return Json.toString( this );
    }
}
