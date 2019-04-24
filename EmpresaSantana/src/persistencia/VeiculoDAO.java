package persistencia;

import java.util.List;

import entidades.VeiculosAutonomos;

public interface VeiculoDAO {

	public List<VeiculosAutonomos> buscarPorCapacidade(double peso) throws Exception;

	public void salvar(VeiculosAutonomos veiculo) throws Exception;

	public void atualizarPosicao(VeiculosAutonomos veiculo) throws Exception;
}
