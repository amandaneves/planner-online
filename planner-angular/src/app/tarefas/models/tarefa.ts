import { TarefaItem } from "./tarefa-item";

export interface Tarefa {
  id: string,
  descricao: string,
  categoriaId: string,
  ordem: number,
  data: string,
  hora: string,
  concluida: boolean,
  notificar: boolean,
  repetir: boolean,
  itens: TarefaItem[]
}
