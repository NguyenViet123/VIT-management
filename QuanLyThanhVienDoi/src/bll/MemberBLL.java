/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dal.MemberDAL;
import entity.Member;
import java.util.ArrayList;

/**
 *
 * @author Viet_dz
 */
public class MemberBLL {
    MemberDAL memdal = new MemberDAL();
    
    public boolean addMember(Member mem){
        return memdal.addMember(mem);
    }
    
    public boolean deleteMember(String id){
        return memdal.deleteMember(id);
    }
    
    public ArrayList<Member> getAllMember(){
        return memdal.getAllMembers();
    }
    
    public boolean mamagementLogin(String id, String pass){
    return memdal.managementLogin(id, pass);
    }
    
    public Member searchMember(String id){
        return memdal.searchMember(id);
    }
    
    public boolean updateMember(Member mem){
        return memdal.updateMember(mem);
    }
}
