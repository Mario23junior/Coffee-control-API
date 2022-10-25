package br.com.coffe.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.CallableStatement;

import java.util.ArrayList;
import java.util.List;

import br.com.coffe.model.Coffe;

public class cofferRepository extends Repository {

	public static List<Coffe> findAll() {

		String sql = "SELECT * FROM coffe";
		List<Coffe> retorno = new ArrayList<Coffe>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Coffe cafe = new Coffe();
				cafe.setNome(rs.getString("Nome"));
				cafe.setPreco(rs.getDouble("preco"));
				cafe.setDataDeFabricacao(rs.getDate("data_de_fabricacao").toLocalDate());
				cafe.setDataDeValidade(rs.getDate("data_de_validade").toLocalDate());
				retorno.add(cafe);
			}

			if (rs.isBeforeFirst()) {
				System.out.println("Não foram encontrados registros no banco de dados");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não foi possivel consultar cafes.");
		}
		return retorno;
	}

	public static Coffe save(Coffe coffe) {
		String sql = "INSERT INTO coffe(ID,NOME,PRECO,DATA_DE_FABRICACAO,DATA_DE_VALIDADE)" +
	    "VALUES(?,?,?,?,?)";

		CallableStatement cs = null;
		try {
			cs = getConnection().prepareCall(sql);

			cs.setString(1, coffe.getNome());
			cs.setDouble(2, coffe.getPreco());
			cs.setDate(3, Date.valueOf(coffe.getDataDeFabricacao()));
			cs.setDate(4, Date.valueOf(coffe.getDataDeValidade()));

			cs.registerOutParameter(5, Types.INTEGER);
			cs.executeUpdate();
			coffe.setId((long) cs.getInt(5));

			return coffe;

		} catch (SQLException e) {
			System.out.println("Erro ao salvar caffe no banco de dados" + e.getMessage());
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (SQLException e) {
					System.out.println("Não foi possivel fechar o collable stament");
				}
			}
		}

		return null;
	}
}
