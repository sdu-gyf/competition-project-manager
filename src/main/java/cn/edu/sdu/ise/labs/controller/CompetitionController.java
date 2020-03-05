package cn.edu.sdu.ise.labs.controller;

import cn.edu.sdu.ise.labs.dto.CompetitionEventDTO;
import cn.edu.sdu.ise.labs.model.ResultContext;
import cn.edu.sdu.ise.labs.service.CompetitionEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("athlete")
public class CompetitionController {

    @Autowired
    private CompetitionEventService competitionEventService;

    /**
     * get接口
     * Get方法
     *
     * @param eventCode
     * @return
     */
    @GetMapping("get")
    public ResultContext getByCode(String eventCode) {
        return ResultContext.returnSuccess(competitionEventService.getAthlete(eventCode));
    }

    /**
     * list接口
     * Get方法
     *
     * @param competitionEventDTO
     * @return
     */
    @GetMapping("list")
    public ResultContext listByName(@RequestBody CompetitionEventDTO competitionEventDTO) {
        return ResultContext.returnSuccess(competitionEventService.listAthlete(competitionEventDTO));
    }

    /**
     * add接口
     * Post方法
     *
     * @param competitionEventDTO
     * @return
     */
    @PostMapping("add")
    public ResultContext add(@RequestBody CompetitionEventDTO competitionEventDTO) {
        return ResultContext.returnSuccess(competitionEventService.addAthlete(competitionEventDTO));
    }

    /**
     * update接口
     * Post方法
     *
     * @param competitionEventDTO
     * @return
     */
    @PostMapping("update")
    public ResultContext update(@RequestBody CompetitionEventDTO competitionEventDTO) {
        return ResultContext.returnSuccess(competitionEventService.updateAthlete(competitionEventDTO));
    }

    /**
     * delete接口
     * Post方法
     *
     * @param codeList
     * @return
     */
    @PostMapping("delete")
    public ResultContext delete(@RequestBody List<String> codeList) {
        competitionEventService.delateAthlete(codeList);
        return ResultContext.returnSuccess(true);
    }
}
