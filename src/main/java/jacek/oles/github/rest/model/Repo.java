package jacek.oles.github.rest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Repo {
    private String fullName, description, cloneUrl, stars, createdAt;

    public Repo(jacek.oles.github.rest.model.com.github.api.Repo githubApiRepo) {
        this.setFullName(githubApiRepo.getFull_name());
        this.setDescription(githubApiRepo.getDescription());
        this.setCloneUrl(githubApiRepo.getClone_url());
        this.setStars(githubApiRepo.getStargazers_count());
        this.setCreatedAt(githubApiRepo.getCreated_at());
    }
}
