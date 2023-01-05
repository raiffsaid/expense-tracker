import styled from "styled-components";

export const Table = styled.table`
  background-color: #70aeea;
  box-shadow: 0 0 5px #9ecbf2;
  width: 100%;
  padding: 20px;
  border-radius: 10px;
  margin-top: 20px;
`;

export const TableHeadColumn = styled.th<{ width?: number }>`
  width: ${props => props.width ? `${props.width}px` : 'auto'};
  padding: 10px 0;
  text-align: left;
`;