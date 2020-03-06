package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.dao.CompetitionEventExtMapper;
import cn.edu.sdu.ise.labs.dto.CompetitionEventDTO;
import cn.edu.sdu.ise.labs.service.CompetitionEventService;
import cn.edu.sdu.ise.labs.vo.CompetitionEventVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompetitionServiceImpl implements CompetitionEventService {

    @Autowired
    private CompetitionEventExtMapper competitionEventExtMapper;

    @Override
    public CompetitionEventVO getAthlete(String eventCode) {
        return null;
    }

    @Override
    public List<CompetitionEventVO> listAthlete(CompetitionEventDTO competitionEventDTO) {
        return null;
    }

    @Override
    public String addAthlete(CompetitionEventDTO competitionEventDTO) {
        return null;
    }

    @Override
    public String updateAthlete(CompetitionEventDTO competitionEventDTO) {
        return null;
    }

    @Override
    public String delateAthlete(List<String> athleteCodesList) {
        return null;
    }
}
