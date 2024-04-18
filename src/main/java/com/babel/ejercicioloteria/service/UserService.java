package com.babel.ejercicioloteria.service;

import com.babel.ejercicioloteria.controller.UserControlller;
import com.babel.ejercicioloteria.model.Bet;
import com.babel.ejercicioloteria.model.User;
import com.babel.ejercicioloteria.model.UserDTO;
import com.babel.ejercicioloteria.repository.IUserRepository;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Aspect
@Service
public class UserService implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserControlller.class);
    private final IUserRepository repository;


    @Pointcut("within(com.babel.ejercicioloteria.service..*)")
    public void applicationPackagePointcut() {
    }

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean addBet(List<Integer> bets, String id){
        Bet bet = new Bet();
        if(bets.size() == 6){
            for (int num : bets){
                if (num > 49 || num < 1){
                    logger.error("ERROR - NUMERO NO PERMITIDO");
                }
            }
            Set<Integer> set = new HashSet<>(bets);
            if(set.size() == 6){
                bet.setBets(set);
                List<Bet> betsUser = repository.getUser(id).getBets();

                for (Bet b : betsUser) {
                    if (b.equals(bet)){
                        logger.warn("WARNING - APUESTA REPETIDA");
                    }
                }

                return repository.addBet(bet,id);
            } else {
                logger.error("ERROR - NUMERO REPETIDO");
            }
        }
        logger.error("ERROR - TAMAÑO INTRODUCIDO INCORRECTO");


        return false;
    }

    @Override
    public void addUser(User user) {
        repository.addUser(user);

    }

    @Override
    public User getUser(String id) {
        User user = repository.getUser(id);
        logger.debug("DEBUG - USUARIO: ");
        logger.debug(user.getId());
        logger.debug(user.getName());
        List<Bet> bets = user.getBets();
        logger.debug(bets.toString());
        return user ;
    }

    @Override
    public Map<String, UserDTO> getUsers () {
        logger.info("OBTENER TODOS LOS USUARIOS: ");
        Map<String, UserDTO> returnDTO =new HashMap<>();
        ArrayList<User> listUser = new ArrayList<>(repository.getUsers().values());
        for(User user : listUser) {
            UserDTO userDto = new UserDTO();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            returnDTO.put(userDto.getId(), userDto);
            logger.debug("Añadir usuario con id: "+user.getId()+" y nombre: "+user.getName());
        }
        return returnDTO;
    }

}
