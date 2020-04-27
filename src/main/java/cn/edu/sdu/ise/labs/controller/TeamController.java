package cn.edu.sdu.ise.labs.controller;

import cn.edu.sdu.ise.labs.dto.TeamDTO;
import cn.edu.sdu.ise.labs.dto.TeamQueryDTO;
import cn.edu.sdu.ise.labs.model.ResultContext;
import cn.edu.sdu.ise.labs.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("get")
    public ResultContext getTeam(String teamCode) {
        return ResultContext.returnSuccess(teamService.getTeam(teamCode));
    }

    @GetMapping("list")
    public ResultContext listTeam(@ModelAttribute TeamQueryDTO teamQueryDTO) {
        return ResultContext.returnSuccess(teamService.listTeam(teamQueryDTO));
    }

    @PostMapping("add")
    public ResultContext addTeam(@RequestBody TeamDTO teamDTO) {
        return ResultContext.returnSuccess(teamService.addTeam(teamDTO));
    }

    @PostMapping("update")
    public ResultContext updateTeam(@RequestBody TeamDTO teamDTO) {
        return ResultContext.returnSuccess(teamService.updateTeam(teamDTO));
    }

    @PostMapping("delete")
    public ResultContext deleteTeam(@RequestBody List<String> teamCodes) {
        return ResultContext.returnSuccess(teamService.deleteTeam(teamCodes));
    }
}
