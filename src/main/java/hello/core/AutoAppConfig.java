package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        /*
        컴포넌트 스캔을 사용하면 앞서 만든 AppConfig나 TestConfig 등이 함께 등록되고 실행되어버린다.
        excludeFilters를 이용해 설정정보는 컴포넌트 스캔 대상에서 제외한다.
        보통은 설정 정보를 제외하지 않지만 기존 예제 코드를 남기기 위해 사용했다.
        */
)
public class AutoAppConfig {

}
