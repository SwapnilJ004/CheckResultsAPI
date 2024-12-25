package Services;
import Repositories.ResultRepository;
import Entities.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<Result> getResultsByVotingId(int votingId) {
        return resultRepository.findByVotingId(votingId);
    }
}