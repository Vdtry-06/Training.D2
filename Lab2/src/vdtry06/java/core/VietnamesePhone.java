package vdtry06.java.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VietnamesePhone extends Phone{
	
	@Override
	public void insertContact(String name, String phone) {
		if(!validName(name)) {
			System.out.println("Loi nhap ten nguoi dung");
		} else if(!validPhone(phone)) {
			System.out.println("Loi nhap so dien thoai nguoi dung");
		} else {
			Contact contact = new Contact();
			contact.setName(name);
			contact.setNumber(phone);
			contacts.add(contact);
			System.out.println("Đã cập nhật số điện thoại!");
		}
		
	}

	@Override
	public void removeContact(String name) {
		Contact removeUser = null;
		for(Contact contact : contacts) {
			if(contact.getName().equalsIgnoreCase(name)) {
				removeUser = contact;
			}
		}
		if(removeUser != null) {
			contacts.remove(removeUser);
			System.out.println("Đã xóa thông tin liên lạc");
		} else {
			System.out.println("Khong tim thay ten lien lac de xoa");
		}
	}

	@Override
	public void updateContact(String name, String newPhone) {
		if(!validName(name)) {
			System.out.println("Loi nhap ten nguoi dung");
		} else if(!validPhone(newPhone)) {
			System.out.println("Loi nhap so dien thoai nguoi dung");
		} else {
			int index = 0;
			boolean check = false;
			Contact contact = new Contact();
			for(int i = 0; i < contacts.size(); ++i) {
				if(contacts.get(i).getName().equals(name)) {
					index = i;
					contact.setName(name);
					contact.setNumber(newPhone);
					check = true;
				}
			}
			if(check) {
				contacts.set(index, contact);
				System.out.println("Đã thêm liên lạc thành công!");
			}
			else {
				System.out.println("Khong tim thay ten lien lac de cap nhat");
			}
		}
	}

	@Override
	public void searchContact(String name) {
		boolean check = false;
		String lowerName = name.toLowerCase();
		for(Contact contact : contacts) {
			if(contact.getName().toLowerCase().contains(lowerName)) {
				System.out.println(contact.toString());
				check = true;
			}
		}
		if(!check) System.out.print("Khong tim thay ten lien lac");
	}
	
	@Override
	public void listAllContacts() {
		for(Contact contact: contacts) {
			System.out.println(contact.toString());
		}
	}

	private boolean validName(String name) {
		String regex = "^[A-ZÀ-Ỹ][a-zà-ỹ]+(\\s[A-ZÀ-Ỹ][a-zà-ỹ]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
	}
	
	private boolean validPhone(String phone) {
		String regex = "^(0[3|5|7|8|9])[0-9]{8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}
}
