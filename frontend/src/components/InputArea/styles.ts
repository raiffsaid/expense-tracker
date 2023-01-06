import styled from 'styled-components';

export const Container = styled.div`
  background-color: #70aeea;
  box-shadow: 0 0 5px #70aeea;
  border-radius: 10px;
  padding: 20px;
  margin-top: 20px;
  display: flex;
  align-items: center;

  @media (max-width: 768px) {
    display: grid;
    grid-template-columns: 1fr;
  }
`;
export const InputLabel = styled.label`
  flex: 1;
  margin: 10px;
`;
export const InputTitle = styled.div`
  font-weight: bold;
  margin-bottom: 5px;
  color: #f1f7fd;
`;
export const Input = styled.input`
  width: 100%;
  height: 30px;
  padding: 0 5px;
  border: 1px solid lightblue;
  border-radius: 5px;
  background-color: #c6dff7;
`;
export const Select = styled.select`
  width: 100%;
  height: 30px;
  padding: 0 5px;
  border: 1px solid lightblue;
  border-radius: 5px;
  background-color: #c6dff7;
`;
export const Button = styled.button`
  width: 100%;
  height: 30px;
  padding: 0 5px;
  border: 1px solid #c6dff7;
  border-radius: 5px;
  background-color: #c6dff7;
  color: #000;
  cursor: pointer;
  transition: color 0.3s, border 0.3s, background-color 0.3s;

  &:hover {
      background-color: #2d4fa0;
      color: #fff;
      border: 1px solid #2d4fa0;
  }
`;
