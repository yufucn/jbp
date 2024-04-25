package yufu.jbp.guids;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

import java.util.UUID;

/**
 * @author wang
 */
public class SnowflakeIdGenerator {
    private static final Snowflake snowflake = IdUtil.createSnowflake(0,0);

    public static synchronized Long generateId() {
        return snowflake.nextId();
    }

    private static long generateUniqueId() {
        return UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;
    }
}
