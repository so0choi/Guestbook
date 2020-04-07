package kr.or.connect.guestbook.dao;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.guestbook.config.ApplicationConfig;
import kr.or.connect.guestbook.dto.Guestbook;

public class GuestbookDaoTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestbookDao guestbookDao = ac.getBean(GuestbookDao.class);
		
		Guestbook guestbook = new Guestbook();
		guestbook.setName("최소영");
		guestbook.setContent("안녕하세요");
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		System.out.println("id:"+id);
		
		Guestbook guestbook2 = new Guestbook();
		guestbook2.setName("최소영");
		guestbook2.setContent("안녕하세요");
		guestbook2.setRegdate(new Date());
		Long id2=guestbookDao.insert(guestbook2);
		System.out.println("id: "+id2);
		
		List<Guestbook> list = guestbookDao.selectAll(0, 5);
		for(Guestbook gb: list)
			System.out.println(gb);
	}

}
