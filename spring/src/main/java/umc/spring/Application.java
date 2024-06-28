package umc.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ SpringBootApplication 이 @ComponentScan 을 이미 가지고 있음
// @ ComponentScan 어노테이션이 컴포넌트(Component)를 스캔
// @ Component 스프링에게 이 클래스를 자바 빈으로 등록시킴 ( @Controller , @Service , @Repository 에는 @ Component 가 달려있음)
// @ AutoWired 애플리케이션 실행 중 어떤 오브젝트가 필요한 경우 의존하는 다른 오브젝트를 찾아 연결함
// + @AutoWired  로 애플리케이션 컨텍스트에 등록된 자바 빈을 찾을 수 있는 이유는 @ Component 를 이용
// 스프링은 베이스 패키지와 그 하위 패키지에서 자바 빈을 찾아 스프링의 의존성 주입 컨테이너 오브젝트 즉 , ApplicationContext 에 주입

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
