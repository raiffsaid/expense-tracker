import * as C from "./styles";
import { Item } from "../../types/Item";
import { formatDate } from "../../helpers/dateFilter";
import { categories } from "../../data/categories";
import { Trash } from "phosphor-react";

type Props = {
  onDeleteItem: (arg: string) => void;
  item: Item;
}

export function TableItem({ item, onDeleteItem }: Props) {
  const handleDeleteItem = () => {
    item?.id ? (onDeleteItem(item?.id)) : null;
  };

  return (
    <C.TableLine>
      <C.TableColumn>{formatDate(item.date)}</C.TableColumn>
      <C.TableColumn>
        <C.Category color={categories[item.category].color}>
          {categories[item.category].title}
        </C.Category>
      </C.TableColumn>
      <C.TableColumn>{item.title}</C.TableColumn>
      <C.TableColumn>
        <C.Value color={categories[item.category].expense ? 'red' : 'green'}>
          {new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(item.value)}
        </C.Value>
      </C.TableColumn>
      <C.TableColumn>
        <C.Button onClick={handleDeleteItem} >
          <Trash size={22} />
        </C.Button>
      </C.TableColumn>
    </C.TableLine>
  );
}