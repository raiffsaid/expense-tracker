import * as C from "./styles";
import { Item } from "../../types/Item";
import { TableItem } from "../TableItem";

type Props = {
  onDeleteItem: (arg: Item) => void;
  list: any[];
}

export function TableArea({ list, onDeleteItem }: Props) {
  return (
    <C.Table>
      <thead>
        <tr>
          <C.TableHeadColumn width={100}>Data</C.TableHeadColumn>
          <C.TableHeadColumn width={130}>Categoria</C.TableHeadColumn>
          <C.TableHeadColumn>Título</C.TableHeadColumn>
          <C.TableHeadColumn width={150}>Valor</C.TableHeadColumn>
          <C.TableHeadColumn width={50}></C.TableHeadColumn>
        </tr>
      </thead>
      <tbody>
        {list.map((item, index) => (
          <TableItem key={index} item={item} onDeleteItem={onDeleteItem} />
        ))}
      </tbody>
    </C.Table>
  );
}