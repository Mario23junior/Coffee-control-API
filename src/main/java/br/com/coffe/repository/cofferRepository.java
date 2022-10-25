package br.com.coffe.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.coffe.model.Coffe;

public class cofferRepository extends Repository{
  
	 
	public static List<Coffe> findAll(){
		
		String sql = "SELECT * FROM coffe";
		List<Coffe> retorno = new ArrayList<Coffe>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Coffe cafe = new Coffe();
				cafe.setNome(rs.getString("Nome"));
				cafe.setPreco(rs.getDouble("preco"));
				cafe.setDataDeFabricacao(rs.getDate("data_de_fabricacao").toLocalDate());
				cafe.setDataDeValidade(rs.getDate("data_de_validade").toLocalDate());
				retorno.add(cafe);
			}
			
			if(rs.isBeforeFirst()) {
				System.out.println("Não foram encontrados registros no banco de dados");
			}
			
		} catch (SQLException e) {
 			e.printStackTrace();
 			System.out.println("Não foi possivel consultar cafes.");
		}
		return retorno;
	}
}








