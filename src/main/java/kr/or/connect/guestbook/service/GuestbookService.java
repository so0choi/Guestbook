package kr.or.connect.guestbook.service;

import java.util.List;

import kr.or.connect.guestbook.dto.Guestbook;

public interface GuestbookService {
	public static final Integer LIMIT=5;
	public Guestbook addGuestbook(Guestbook guestbook, String ip);
	public int deleteGuestbook(Long id, String ip);
	public int getCount();
	public List<Guestbook> getGuestbooks(Integer start);
}
