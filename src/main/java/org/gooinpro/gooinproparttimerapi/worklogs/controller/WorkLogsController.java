package org.gooinpro.gooinproparttimerapi.worklogs.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gooinpro.gooinproparttimerapi.worklogs.dto.WorkLogsInDTO;
import org.gooinpro.gooinproparttimerapi.worklogs.dto.WorkLogsOutDTO;
import org.gooinpro.gooinproparttimerapi.worklogs.dto.WorkLogsTimeDTO;
import org.gooinpro.gooinproparttimerapi.worklogs.service.WorkLogsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/part/api/v1/worklog")
@RequiredArgsConstructor
@Log4j2
public class WorkLogsController {

    private final WorkLogsService workLogsService;

    @PostMapping("/start")
    public ResponseEntity<WorkLogsInDTO> startTime(@RequestBody WorkLogsTimeDTO workLogsTimeDTO) {
        log.info(" worklog start");

        return ResponseEntity.ok(workLogsService.startTime(workLogsTimeDTO));
    }

    @PutMapping("/end")
    public ResponseEntity<WorkLogsOutDTO> endTime(@RequestBody WorkLogsTimeDTO workLogsTimeDTO) {
        log.info(" worklog end");

        return ResponseEntity.ok(workLogsService.endTime(workLogsTimeDTO));
    }

    @GetMapping("/realStart")
    public ResponseEntity<WorkLogsInDTO> realStart(@RequestParam Long pno, @RequestParam Long jmno) {
        log.info(" worklog realStart");

        return ResponseEntity.ok(workLogsService.getTodayStartTimeStatus(pno, jmno));
    }

    @GetMapping("/realEnd")
    public ResponseEntity<WorkLogsOutDTO> realEnd(@RequestParam Long pno, @RequestParam Long jmno) {
        log.info(" worklog realEnd");

        return ResponseEntity.ok(workLogsService.getTodayEndTimeStatus(pno, jmno));
    }

}
