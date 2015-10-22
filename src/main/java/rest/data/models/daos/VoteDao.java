package rest.data.models.daos;

import java.util.List;

import rest.business.model.entities.Theme;
import rest.business.model.entities.Vote;

public interface VoteDao extends GenericDao<Vote, Integer> {

    List<Vote> findByTheme(Theme theme);

}
