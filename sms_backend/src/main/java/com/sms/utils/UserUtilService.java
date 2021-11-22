package com.sms.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dto.requests.UserRequest;
import com.sms.dto.requests.UserType;
import com.sms.dto.requests.UserUpdateRequest;
import com.sms.dto.responses.UserResponse;
import com.sms.entities.Parent;
import com.sms.entities.Student;
import com.sms.entities.Teacher;
import com.sms.entities.User;
import com.sms.repositories.ParentRepository;
import com.sms.repositories.StudentRepository;
import com.sms.repositories.TeacherRepository;
import com.sms.repositories.UserRepository;

@Service
public class UserUtilService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	ParentRepository parentRepo;

	@Autowired
	TeacherRepository teacherRepo;

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	ParentUtilService parentUtil;
	
	@Autowired
	TeacherUtilService teacherUtil;
	
	@Autowired
	StudentUtilService studentUtil;

	public User convertUserRequestToUser(UserRequest req) {
		User user = new User();
		user.setEmail(req.getEmail());
		user.setName(req.getFirstName()+" "+req.getLastName());
		user.setPassword(req.getPassword());
		if(req.getUserType().equalsIgnoreCase("student"))
			user.setUserType(UserType.STUDENT);
		else if(req.getUserType().equalsIgnoreCase("parent"))
			user.setUserType(UserType.PARENT);
		else if(req.getUserType().equalsIgnoreCase("teacher"))
			user.setUserType(UserType.TEACHER);
		return user;
	}

	public Student convertUserRequestToStudent(UserRequest req, User user) {
		Student stu = new Student();
		stu.setDob(req.getDob());
		stu.setDoj(req.getDoj());
		stu.setFirstName(req.getFirstName());
		stu.setLastName(req.getLastName());
		stu.setMobile(req.getMobile());
		stu.setPhone(req.getPhone());
		stu.setParent(req.getParent());
		stu.setUser(user);
		return stu;
	}

	public Teacher convertUserRequestToTeacher(UserRequest req, User user) {
		Teacher tea = new Teacher();
		tea.setDob(req.getDob());
		tea.setFirstName(req.getFirstName());
		tea.setLastName(req.getLastName());
		tea.setMobile(req.getMobile());
		tea.setPhone(req.getPhone());
		tea.setUser(user);
		return tea;
	}

	public Parent convertUserRequestToParent(UserRequest req, User user) {
		Parent par = new Parent();
		par.setDob(req.getDob());
		par.setFirstName(req.getFirstName());
		par.setLastName(req.getLastName());
		par.setMobile(req.getMobile());
		par.setPhone(req.getPhone());
		par.setUser(user);
		return par;
	}

	public UserResponse convertUserToUserResponse(User user) {
		UserResponse res = new UserResponse();
		res.setId(user.getId());
		res.setName(user.getName());
		res.setEmail(user.getEmail());
		res.setUserType(user.getUserType().userType);
		if(user.getUserType().equals(UserType.PARENT)) {
			res.setUser(parentUtil.convertParentObjectToParentRes(parentRepo.findByUserId(user.getId())));
		}
		else if(user.getUserType().equals(UserType.STUDENT)) {
			res.setUser(studentUtil.convertStudentObjectToStudentRes(studentRepo.findByUserId(user.getId())));
		}
		else if(user.getUserType().equals(UserType.TEACHER)) {
			res.setUser(teacherUtil.convertTeacherObjToTeacherRes(teacherRepo.findByUserId(user.getId())));
		}
		return res;
	}

	public boolean userWithEmailExists(String email) {
		if(userRepo.findByEmail(email) != null) {
			return true;
		}
		else return false;
	}

	public Optional<User> isUserWithIdExists(Long id) {
		return userRepo.findById(id);
	}

	public Map<Boolean, User> canUpdate(UserUpdateRequest req, User user) {
		Map<Boolean, User> response = new HashMap<>();
		if(req.getFirstName() != null && !req.getFirstName().isEmpty() && req.getLastName() != null && !req.getLastName().isEmpty()) {
			String name = req.getFirstName() + " " + req.getLastName();
			if(!req.getFirstName().equalsIgnoreCase(name)) {
				user.setName(name);
			}
		}
		if(req.getEmail() != null && !req.getEmail().isEmpty()) {
			if(!req.getEmail().equals(user.getEmail())) {
				user.setEmail(null);
			}
		}
		if(req.getPassword() != null && !req.getPassword().isEmpty()) {
			if(!req.getPassword().equals(user.getPassword())) {
				user.setPassword(req.getPassword());
			}
		}
		response.put(true, user);
		return response;
	}

}
