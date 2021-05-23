package com.eiin.institutionEiinGenerate.service;

import com.eiin.institutionEiinGenerate.entity.Action;
import com.eiin.institutionEiinGenerate.entity.ActionLog;
import com.eiin.institutionEiinGenerate.entity.ModuleName;
import com.eiin.institutionEiinGenerate.repository.ActionLogRepository;
import com.eiin.institutionEiinGenerate.utils.WebUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActionLogService {
    private final ActionLogRepository repository;

    public ActionLog publishActivity(Action action, ModuleName moduleName,Long documentId,String comments)
    {
        ActionLog log = new ActionLog();
        log.setAction(action);
        log.setModuleName(moduleName);
        log.setDocumentId(documentId);
        log.setIpAddress(WebUtils.getCurrentRequest().getRequestURI());
        log.setComments(comments);
        repository.save(log);
        return null;

    }
}
