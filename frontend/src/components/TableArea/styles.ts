import styled from "styled-components";

export const Table = styled.table`
  background-color: #70aeea;
  box-shadow: 0 0 5px #70aeea;
  width: 100%;
  padding: 20px;
  border-radius: 10px;
  margin-top: 20px;
  border-collapse: collapse;
`;

export const TableHeadColumn = styled.th<{ width?: number }>`
  background-color: #3a74d6;
  width: ${props => props.width ? `${props.width}px` : 'auto'};
  padding: 10px 15px;
  text-align: left;
  color: #fff;

  &:first-child {
    border-radius: 10px 0 0 0;
  }

  &:last-child {
    border-radius: 0 10px 0 0;
  }
`;