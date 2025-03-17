package log4j.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LogExampleService {
    private static final Logger logger = LogManager.getLogger(LogExampleService.class);

	public void execute() {
		logger.debug("DEBUG - Đây là log debug");
        logger.info("INFO - Đây là log thông tin");
        logger.warn("WARNING - Đây là log cảnh báo");
        logger.error("ERROR - Đây là log lỗi nghiêm trọng");
	}
}
