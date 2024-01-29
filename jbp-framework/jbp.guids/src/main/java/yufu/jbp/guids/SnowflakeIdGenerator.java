package yufu.jbp.guids;

import cn.hutool.core.lang.Snowflake;

import java.util.UUID;

/**
 * @author wang
 */
public class SnowflakeIdGenerator {
    private static final Snowflake snowflake = new Snowflake(generateUniqueId(), generateUniqueId());

    public static synchronized Long generateId() {
        return snowflake.nextId();
    }

    private static long generateUniqueId() {
        return UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;
    }
}
