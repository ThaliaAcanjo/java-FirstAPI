package dio.myFirstAPI.repository;

import dio.myFirstAPI.handler.BusinessException;
import dio.myFirstAPI.handler.CampoObrigatorioException;
import dio.myFirstAPI.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoy {
		public void save(User user){
				if (user.getLogin() == null)
						throw new CampoObrigatorioException("login");

				if (user.getPassword() == null)
						throw new CampoObrigatorioException("password");

				if (user.getId() == null)
						System.out.println("Save - recebe user na camada do repository");
				else
						System.out.println("Update - recebe user na camada do repository");

				System.out.println(user);
		}

		public void deleteById(Integer id){
				System.out.println(String.format("Delete/id - recebe o id: %d ", id));
		}

		public List<User> findAll(){
				List<User> listUser = new ArrayList<>();
				listUser.add(new User(1, "Thalia", "123"));
				listUser.add(new User(2, "Admin", "1234"));
				listUser.add(new User(3, "Técnico", "12345"));
				return listUser;
		}
		public User findByName(String name){
				return new User(1, "Thalia", "123");
		}

}
