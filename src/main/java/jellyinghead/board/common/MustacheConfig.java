package jellyinghead.board.common;

import com.samskivert.mustache.Mustache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Configuration
public class MustacheConfig {

    @Bean
    public Mustache.Compiler mustacheCompiler(Mustache.TemplateLoader mustacheTemplateLoader) {
        return Mustache.compiler()
                .withLoader(mustacheTemplateLoader)
                .withFormatter(customDateFormatter());
    }

    private Mustache.Formatter customDateFormatter() {
        return value -> {
            if (value instanceof Instant instant) {
                return new SimpleDateFormat("yyyy.MM.dd HH:mm").format(Date.from(instant));
            }
            return String.valueOf(value);
        };
    }
}
